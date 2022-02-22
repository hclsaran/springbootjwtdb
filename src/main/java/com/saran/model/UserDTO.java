package com.saran.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	//DTO model is responsible for getting values from user and passing it to the 
	//DAO(Data Access Object) for inserting into the database
	private String username;
	private String password;

}
