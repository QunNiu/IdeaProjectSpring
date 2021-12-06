package cn.edu.ctgu.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author NiuQun
 * @date 2021/10/18
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "hello world";
    }

}
