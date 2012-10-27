package com.example.exemploandroid;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private DatabaseHelper helper;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		helper = new DatabaseHelper(this);		
	}
	
	public void onPersistir(View v) {
		Cliente cliente = new Cliente();
		cliente.setNome("Maria");
		cliente.setDataNascimento(new Date());
		cliente.setEndereco("Rua Tal");
		
		ClienteDao dao;
		try {
			dao = new ClienteDao(helper.getConnectionSource());
			dao.create(cliente);

			List<Cliente> clientes  = dao.queryForAll();
			for (Cliente c : clientes) {
				System.out.println("Nome: " + c.getNome() + " Endereco: " + c.getEndereco() + " DataNascimento: " + c.getDataNascimento());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
