package com.example.demo02.modelo;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(name="email")
    private String email;
	@Column(name="first_name")
    private String first_name;
	@Column(name="last_name")
    private String last_name;
	@Column(name="avatar")
    private String avatar;

	public UsuarioModel(){
		
	}

    public long getId() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

    public String getFirst_Name() {
		return first_name;
	}
    
	public void setFirst_Name(String first_name) {
		this.first_name = first_name;
	}

    public String getLast_Name() {
		return last_name;
	}
    
	public void setLast_Name(String last_name) {
		this.last_name = last_name;
	}

    public String getEmail() {
		return email;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}

    public String getAvatar() {
		return avatar;
	}
    
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
    
}
