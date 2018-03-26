package com.seracorp.demo.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seracorp.demo.model.LoginJson;

import feign.Headers;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Screen;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;

@SpringBootApplication
@EnableFeignClients
public class FeignDemoClient extends Application{
	
	private ConfigurableApplicationContext context;
    private Parent rootNode;	

	public static void main(String[] args) {
		//SpringApplication.run(FeignDemoClient.class, args);
		Application.launch(args);
	}
	
	@Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(FeignDemoClient.class);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));
 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        loader.setControllerFactory(context::getBean);
        rootNode = loader.load();
    }
	
	@Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        double width = visualBounds.getWidth();
        double height = visualBounds.getHeight();
 
        primaryStage.setScene(new Scene(rootNode, width, height));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
 
    @Override
    public void stop() throws Exception {
        context.close();
    }
	

	@RestController
	static class DemoController {

		@Autowired
		private RedditClient redditClient;

		@GetMapping("/posts")
		public String posts() {
			String posts = redditClient.posts();
			
			return posts;
		}
	}

	@RestController
	static class TvDbController {
		@Autowired
		private TVDBClient tvdbClient;

		@PostMapping("/login")
		@Headers("Content-Type: application/json")
		public String login(@RequestBody LoginJson loginJson) {
			System.out.println("Hit");
			return tvdbClient.login(loginJson).getBody();
		}
	}
}
