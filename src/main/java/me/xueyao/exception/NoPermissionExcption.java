package me.xueyao.exception;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/24 17:28
 */
public class NoPermissionExcption extends RuntimeException {
    public NoPermissionExcption(String message) {
        super(message);
    }
}
