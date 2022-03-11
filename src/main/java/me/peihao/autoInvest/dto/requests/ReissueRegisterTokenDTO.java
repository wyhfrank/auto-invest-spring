package me.peihao.autoInvest.dto.requests;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReissueRegisterTokenDTO {

  @NotNull
  String username;

}
