package org.seckill.exception;

/**
 * 重复秒杀异常(运行期异常)。Java 异常包括 编译期异常和运行期异常
 */
public class RepeatKillException extends SeckillCloseException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
