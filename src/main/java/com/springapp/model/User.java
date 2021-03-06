package com.springapp.model;

public class User {
	
	 	private int id;
	    private String username;
	    private String password;
	    private String nombres;
	    private String tipo;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getNombres() {
	        return nombres;
	    }

	    public void setNombres(String nombres) {
	        this.nombres = nombres;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", nombres=" + nombres
					+ ", tipo=" + tipo + "]";
		}
	    
	    
	    
}
