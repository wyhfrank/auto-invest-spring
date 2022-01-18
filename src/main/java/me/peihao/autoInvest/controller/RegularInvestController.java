package me.peihao.autoInvest.controller;

import java.security.Principal;
import javax.validation.Valid;
import me.peihao.autoInvest.common.ResultUtil;
import me.peihao.autoInvest.constant.ResultInfoConstants;
import me.peihao.autoInvest.dto.requests.UpdateRegularInvestDTO;
import me.peihao.autoInvest.model.AppUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.peihao.autoInvest.dto.requests.RegisterRegularInvestRequestDTO;

@RestController
@RequestMapping("/regular_invest")
public class RegularInvestController {

    @PostMapping
    public ResponseEntity<String> registerRegularInvest(
        @Valid @RequestBody RegisterRegularInvestRequestDTO registerRegularInvestRequestDTO) {
        // TODO: Need to be Implemented
        System.out.println(registerRegularInvestRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).
            body(ResultUtil.buildResult(ResultInfoConstants.SUCCESS,
                registerRegularInvestRequestDTO));
    }

    @GetMapping
    public ResponseEntity<String> fetchRegularInvest(@PathVariable String crypto) {
        // TODO: Need to be Implemented
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<String> fetchAllRegularInvest() {
        // TODO: Need to be Implemented
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<String> updateRegularInvest(
        @Valid @RequestBody UpdateRegularInvestDTO updateRegularInvestDTO) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> Hello(@AuthenticationPrincipal AppUser targetUser){
        System.out.println("Hello World");
        System.out.println(targetUser.getUsername());
        System.out.println(targetUser.getEmail());
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
