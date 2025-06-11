// eu quero que configures bem este main activity para poder usar o spashactivity ao abrir a app. nao adicionaes nada na pagina depois de abrir o splashactivity. eu apenas quero que o splash abra
package com.example.homesurveilapp
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homesurveilapp.databinding.ActivityMainBinding
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicia o SplashActivity ao abrir o MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SplashActivity::class.java))
            finish()
        }, 5000) // 5 segundos
    }
}

    override fun onDestroy() {
        super.onDestroy()
        // Libera recursos, se necessário
    }
}
// Não há necessidade de adicionar nada na página após abrir o SplashActivity
// O SplashActivity será responsável por exibir a tela de carregamento
// e redirecionar para o MainActivity após o tempo especificado.
// Certifique-se de que o SplashActivity esteja configurado corretamente no AndroidManifest.xml
// para ser a atividade inicial da aplicação.
// No AndroidManifest.xml, defina o SplashActivity como a atividade inicial:
// <activity android:name=".SplashActivity">
//     <intent-filter>
//         <action android:name="android.intent.action.MAIN" />
//         <category android:name="android.intent.category.LAUNCHER" />
//     </intent-filter>
// </activity>
// Certifique-se de que o SplashActivity esteja configurado corretamente no AndroidManifest.xml
// para ser a atividade inicial da aplicação.

// No AndroidManifest.xml, defina o SplashActivity como a atividade inicial:
// <activity android:name=".SplashActivity">
//     <intent-filter>
//         <action android:name="android.intent.action.MAIN" />
//         <category android:name="android.intent.category.LAUNCHER" />
//     </intent-filter>
// </activity>
// Certifique-se de que o SplashActivity esteja configurado corretamente no AndroidManifest.xml
// para ser a atividade inicial da aplicação.
// No AndroidManifest.xml, defina o SplashActivity como a atividade inicial:
// <activity android:name=".SplashActivity">
//     <intent-filter>
//         <action android:name="android.intent.action.MAIN" />



