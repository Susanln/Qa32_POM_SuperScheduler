package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.testng.annotations.DataProvider;

@ToString
@Builder
@Setter
@Getter
@Log
public class Auth {
private String email;
private String password;
}
