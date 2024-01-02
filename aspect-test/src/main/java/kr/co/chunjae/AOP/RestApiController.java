package kr.co.chunjae.AOP;
import kr.co.chunjae.AOP.annotation.Timer;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
//aop 개념정리 실습
@RestController
@RequestMapping("/aoptest")
public class RestApiController {
    @GetMapping("/get/{id}")
    public void get(@PathVariable Long id,
                      @RequestParam String name) {
        System.out.println("get method");
         System.out.println("get method " + id);
         System.out.println("get method " + name);
//          return id + " " + name;
    }

//    @PostMapping("/post")
//    public User post(@RequestBody User user) {
//        System.out.println("post method : " + user);
//        return user;
//    }

    @Timer
    @PostMapping("/post")
    public User post(@RequestBody User user) throws InterruptedException {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        System.out.println("post method : " + user);
//        Thread.sleep(1000 * 2);
//        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
//
        Thread.sleep(1000*2);
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        stopWatch.stop();
//
//        Thread.sleep(1000 * 2);
//        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());

//        AOP사용
        Thread.sleep(1000*2);
    }

}
