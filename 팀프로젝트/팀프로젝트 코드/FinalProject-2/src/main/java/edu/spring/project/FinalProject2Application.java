package edu.spring.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import admin.AdminController;
import admin.AdminDAO;
import chatbot.NaverChatbotController;
import email.EmailController;
import ingredient.IngredientController;
import ingredient.IngredientDAO;
import main.UserController;
import main.UserDAO;
import mypage.MypageController;
import mypage.MypageDAO;
import notice.NoticeController;
import notice.NoticeDAO;
import recipe.RecipeController;
import recipe.RecipeDAO;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackageClasses = UserController.class)
@ComponentScan(basePackageClasses = RecipeController.class)
@ComponentScan(basePackageClasses = MypageController.class)
@ComponentScan(basePackageClasses = AdminController.class)
@ComponentScan(basePackageClasses = NoticeController.class)
@ComponentScan(basePackageClasses = EmailController.class)
@ComponentScan(basePackageClasses = IngredientController.class)
@ComponentScan(basePackageClasses = NaverChatbotController.class)
@MapperScan(basePackageClasses = UserDAO.class)
@MapperScan(basePackageClasses = RecipeDAO.class)
@MapperScan(basePackageClasses = MypageDAO.class)
@MapperScan(basePackageClasses = AdminDAO.class)
@MapperScan(basePackageClasses = NoticeDAO.class)
@MapperScan(basePackageClasses = IngredientDAO.class)
public class FinalProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalProject2Application.class, args);
	}

}
