package ssnd.mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import ssnd.mobile.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupFullScreen()
        setupNavigation()
    }

    /**
     * Styl aplikacie je nastaveny na fullscreen (pozri themes.xml).
     * Niektore elementy preto presahuju cez systemove elementy ako je napr. statusbar, preto je
     * nevyhnutne nastavit spravne paddingy a pod.
     */
    private fun setupFullScreen() {
        binding.toolbar.setOnApplyWindowInsetsListener { v, insets ->
            val compatInsets = WindowInsetsCompat.toWindowInsetsCompat(insets)
            val statusBarInsets = compatInsets.getInsets(WindowInsetsCompat.Type.statusBars())
            v.setPadding(0, statusBarInsets.top, 0, 0)
            insets
        }
    }

    /**
     * Nastavenie JetPack navigacie. Nasa aplikacia pouziva Toolbar a NavigationDrawer.
     *
     * [Navod pre implementaciu](https://developer.android.com/guide/navigation/navigation-ui)
     */
    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navigation_host) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.aboutFragment, R.id.settingsFragment),
            drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        )

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.navigationDrawer.setupWithNavController(navController)
    }
}