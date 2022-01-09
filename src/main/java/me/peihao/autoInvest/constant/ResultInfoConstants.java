package me.peihao.autoInvest.constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;
import me.peihao.autoInvest.common.ResultInfo;

@NoArgsConstructor
public class ResultInfoConstants {
    public static final ResultInfo SUCCESS = new ResultInfo("00000000", "SUCCESS", "Successful Request", "S");
    public static final ResultInfo PARAM_MISSING = new ResultInfo("00000002", "PARAM_MISSING", "One or more mandatory parameters is/are missing", "F");
    public static final ResultInfo PARAM_ILLEGAL = new ResultInfo("00000004", "PARAM_ILLEGAL", "Illegal parameters. For example, non-numeric input, invalid date", "F");
    public static final ResultInfo INVALID_SIGNATURE = new ResultInfo("00000007", "INVALID_SIGNATURE", "Signature is invalid", "F");
    public static final ResultInfo KEY_NO_FOUND = new ResultInfo("00000008", "KEY_NO_FOUND", "Key is not found", "F");
    public static final ResultInfo BAD_REQUEST = new ResultInfo("00000009", "BAD_REQUEST", "Bad request", "F");
    public static final ResultInfo NO_INTERFACE_DEF = new ResultInfo("00000013", "NO_INTERFACE_DEF", "API is not defined", "F");
    public static final ResultInfo API_IS_INVALID = new ResultInfo("00000014", "API_IS_INVALID", "API is invalid (or not active)", "F");
    public static final ResultInfo MSG_PARSE_ERROR = new ResultInfo("00000015", "MSG_PARSE_ERROR", "Message parsed error", "F");
    public static final ResultInfo FUNCTION_NOT_MATCH = new ResultInfo("00000017", "FUNCTION_NOT_MATCH", "Function parameter does not match API", "F");
    public static final ResultInfo SYSTEM_ERROR = new ResultInfo("00000900", "SYSTEM_ERROR", "System error", "F");

    public static final ResultInfo INVALID_WEEK_DAY = new ResultInfo("01000001", "BAD_REQUEST", "Invalid Week Day Type", "F");
    private static final Map<String, ResultInfo> codeToResultInfo;
    private static final List<ResultInfo> ResultInfoList = new ArrayList<>();
    static {
        ResultInfoList.add(SUCCESS);
        ResultInfoList.add(PARAM_MISSING);
        ResultInfoList.add(PARAM_ILLEGAL);
        ResultInfoList.add(INVALID_SIGNATURE);
        ResultInfoList.add(KEY_NO_FOUND);
        ResultInfoList.add(BAD_REQUEST);
        ResultInfoList.add(NO_INTERFACE_DEF);
        ResultInfoList.add(API_IS_INVALID);
        ResultInfoList.add(FUNCTION_NOT_MATCH);
        ResultInfoList.add(SYSTEM_ERROR);
        ResultInfoList.add(MSG_PARSE_ERROR);

        codeToResultInfo = ResultInfoList.stream().collect(
                Collectors.toMap(ResultInfo::getCode, Function.identity()));
    }

    public static ResultInfo getApiErrorResultInfo(String errorCode) {
        return Optional.ofNullable(codeToResultInfo.get(errorCode)).orElse(ResultInfoConstants.BAD_REQUEST);
    }
}
