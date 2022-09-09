package com.lista.compras.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.lifecycleScope
import com.lista.compras.database.AppDatabase
import com.lista.compras.databinding.ActivityLoginBinding
import com.lista.compras.extensions.vaiPara
import com.lista.compras.preferences.dataStore
import com.lista.compras.preferences.usuarioLogadoPreferences
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val usuarioDao by lazy {
        AppDatabase.instancia(this).usuarioDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoCadastrar()
        configuraBotaoEntrar()
    }

    private fun configuraBotaoEntrar() {
        binding.activityLoginBotaoEntrar.setOnClickListener {
            val usuario = binding.activityLoginUsuario.text.toString()
            val senha = binding.activityLoginSenha.text.toString()
            Log.i("LoginActivity", "onCreate: $usuario - $senha")
            lifecycleScope.launch {
                usuarioDao.autentica(usuario, senha)?.let { usuario ->
                    dataStore.edit { preferences ->
                        preferences[usuarioLogadoPreferences] = usuario.id

                    }
                    vaiPara(ListaProdutosActivity::class.java)
                    finish()
                } ?: Toast.makeText(
                    this@LoginActivity,
                    "Falha na autenticação",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    private fun configuraBotaoCadastrar() {
        binding.activityLoginBotaoCadastrar.setOnClickListener {
            vaiPara(FormularioCadastroUsuarioActivity::class.java)
        }
    }

}