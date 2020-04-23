package pl.rekurencja;
import org.bukkit.plugin.java.JavaPlugin;
import pl.rekurencja.controllers.RecipeController;
import pl.rekurencja.executors.RekurencjaDoc;
import pl.rekurencja.listeners.*;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new KillListener(), this);
        getServer().getPluginManager().registerEvents(new EatListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnListener(), this);
        getServer().getPluginManager().registerEvents(new GetDamagedListener(), this);
        getServer().getPluginManager().registerEvents(new PreventChangeCustomItemsListener(), this);
        this.getCommand("rekurencjadoc").setExecutor(new RekurencjaDoc());
        RecipeController.InitRecipes();
    }

    @Override
    public void onDisable(){
    }
}
