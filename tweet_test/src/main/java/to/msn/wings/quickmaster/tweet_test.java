package to.msn.wings.quickmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Controller
@SpringBootApplication
public class tweet_test {
	Status status;

	  public static void main(String[] args) throws Exception {
		    SpringApplication.run(tweet_test.class, args);
		  }
	
	@PostMapping("/chinchin")
	public String TweetTest444() {
		// このファクトリインスタンスは再利用可能でスレッドセーフです
    	Twitter twitter = TwitterFactory.getSingleton();
		try {
			status = twitter.updateStatus("テストちんちん");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
    	System.out.println("Successfully updated the status to [" + status.getText() + "].");
    	
    	return "index";
	}
	
	@RequestMapping("/")
	  String index() {
	    return "index";
	  }
	
	
}
