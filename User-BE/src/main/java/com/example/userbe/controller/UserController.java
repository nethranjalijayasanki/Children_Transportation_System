//package com.example.userbe.controller;
//
//import com.example.userbe.dto.AuthDTO;
//import com.example.userbe.dto.ResponseDTO;
//import com.example.userbe.dto.UserDTO;
//import com.example.userbe.entity.User;
//import com.example.userbe.service.UserService;
//import com.example.userbe.util.JwtUtil;
//import com.example.userbe.util.VarList;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/user")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class UserController {
//    private final UserService userService;
//    private final JwtUtil jwtUtil;
//
//    //constructor injection
//    public UserController(UserService userService, JwtUtil jwtUtil) {
//        this.userService = userService;
//        this.jwtUtil = jwtUtil;
//    }
//    @GetMapping("/test")
//    public String test(){
//        System.out.println("usercontroller");
//        return "user";
//    }
//
//    @PostMapping(value = "/register")
//    public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid UserDTO userDTO) {
//        try {
//            int res = userService.saveUser(userDTO);
//            switch (res) {
//                case VarList.Created -> {
//                    String token = jwtUtil.generateUserToken(userDTO);
//                    AuthDTO authDTO = new AuthDTO();
//                    authDTO.setEmail(userDTO.getEmail());
//                    authDTO.setToken(token);
//                    return ResponseEntity.status(HttpStatus.OK)
//                            .body(new ResponseDTO(VarList.Created, "Success", authDTO));
//                }
//                case VarList.Not_Acceptable -> {
//                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
//                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
//                }
//                default -> {
//                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
//                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
//                }
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
//        }
//    }
//
//
//
////    @GetMapping("/search/{email}")
////    public ResponseEntity<ResponseDTO> getUserByEmail(@PathVariable String email) {
////        try {
////            UserDTO userDTO = userService.getUserEmail(email);
////            return userDTO != null
////                    ? ResponseEntity.ok(new ResponseDTO(VarList.OK, "User Found", userDTO))
////                    : ResponseEntity.status(HttpStatus.NOT_FOUND)
////                    .body(new ResponseDTO(VarList.Not_Found, "User Not Found", null));
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
////        }
////    }
////    @PutMapping(value = "/update")
////    public ResponseEntity<ResponseDTO> updateUser(@RequestBody @Valid UserDTO userDTO) {
////        try {
////            int res = userService.updateUser(userDTO);
////            return res == VarList.Created
////                    ? ResponseEntity.ok(new ResponseDTO(VarList.OK, "User Updated Successfully", null))
////                    : ResponseEntity.status(HttpStatus.NOT_FOUND)
////                    .body(new ResponseDTO(VarList.Not_Found, "User Not Found", null));
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
////        }
////    }
////@PutMapping(value = "/update/{email}")
////public ResponseEntity<ResponseDTO> updateUser(@PathVariable String email, @RequestBody @Valid UserDTO userDTO) {
////    try {
////        User existingUser = userService.findUserByEmail(email);
////        if (existingUser == null) {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND)
////                    .body(new ResponseDTO(VarList.Not_Found, "User Not Found", null));
////        }
////
////        int res = userService.updateUserByEmail(email, userDTO);
////        return res == VarList.Created
////                ? ResponseEntity.ok(new ResponseDTO(VarList.OK, "User Updated Successfully", null))
////                : ResponseEntity.status(HttpStatus.NOT_FOUND)
////                .body(new ResponseDTO(VarList.Not_Found, "User Not Found", null));
////    } catch (Exception e) {
////        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
////    }
////}
//
////
////    @DeleteMapping("/delete/{email}")
////    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable String email) {
////        try {
////            int res = userService.deleteUser(email);
////            return res == VarList.OK
////                    ? ResponseEntity.ok(new ResponseDTO(VarList.OK, "User Deleted Successfully", null))
////                    : ResponseEntity.status(HttpStatus.NOT_FOUND)
////                    .body(new ResponseDTO(VarList.Not_Found, "User Not Found", null));
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
////        }
////    }
//
//    @GetMapping(value = "/all")
//    public ResponseEntity<ResponseDTO> getAllUsers() {
//        try {
//            List<UserDTO> users = userService.getAllUsers();
//            return !users.isEmpty()
//                    ? ResponseEntity.ok(new ResponseDTO(VarList.OK, "Users Retrieved Successfully", users))
//                    : ResponseEntity.status(HttpStatus.NO_CONTENT)
//                    .body(new ResponseDTO(VarList.No_Content, "No Users Found", null));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
//        }
//    }
//
//
//}
