package com.appcoy.student.api.app;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BaseResponse<T> {
    private String message;
    private Boolean status;
    private T data;

    private static final String OK = "Successful";
    private static final String FAIL = "Unsuccessful";

    public static<T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(OK, true, data);
    }

    public static<T> ResponseEntity<BaseResponse<T>> okResponse() {
        return ResponseEntity.ok(ok(null));
    }
    public static<T> ResponseEntity<BaseResponse<T>> okResponse(T data) {
        return ResponseEntity.ok(ok(data));
    }

    public static<T> BaseResponse<T> fail(String message){
        return new BaseResponse<>(message, false, null);
    }

    public static<T> BaseResponse<T> fail(){
        return new BaseResponse<>(FAIL, false, null);
    }

    public static<T> ResponseEntity<BaseResponse<T>> failResponse() {
        return ResponseEntity.badRequest().body(fail());
    }
}
