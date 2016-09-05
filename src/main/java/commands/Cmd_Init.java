package commands;

import java.io.File;
import java.io.IOException;
//import java.io.PrintStream;
import java.util.List;
import org.bukkit.configuration.file.YamlConfiguration;

public class Cmd_Init {
    private YamlConfiguration customMessages = null;

    public void initConfig() {
        File folder = new File("plugins//TallcraftDeathMessages");
        File file = new File("plugins//TallcraftDeathMessages//messages.yml");
        if (!folder.exists()) {
            folder.mkdir();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
                this.customMessages = YamlConfiguration.loadConfiguration(file);
                List<String> a = this.customMessages.getStringList("was slain by");
                
                a.add("{{player}} was slain by {{killer}}");
                a.add("{{player}} got murdered by {{killer}}");
                a.add("{{player}} got anihalated by {{killer}}");
                a.add("{{killer}} rekt {{player}}");
                a.add("{{player}} got turned into dust by {{killer}}");
                this.customMessages.set("was slain by", a);
                
                a = this.customMessages.getStringList("was blown up by");
                a.add("{{player}} was blown up by {{killer}}");
                a.add("{{player}} got some explosive action from {{killer}}");
                a.add("{{player}} got blown to bits by {{killer}}");
                this.customMessages.set("was blown up by", a);
                
                a = this.customMessages.getStringList("was fireballed by");
                a.add("{{player}} was fireballed by {{killer}}");
                a.add("{{player}} got incinerated by {{killer}}");
                this.customMessages.set("was fireballed by", a);
                
                a = this.customMessages.getStringList("was shot by");
                a.add("{{player}} was shot by {{killer}}");
                a.add("{{player}} got shot in the butt by {{killer}}");
                a.add("{{killer}} 360 no scoped {{player}}");
                a.add("{{player}} took an arrow to the knee");
                a.add("{{player}} didn't realize they were in a shooting range");
                this.customMessages.set("was shot by", a);
                
                a = this.customMessages.getStringList("fell from a high place");
                a.add("{{player}} fell from a high place");
                a.add("{{player}} forgot they couldn't fly");
                a.add("{{player}} thought they could resist gravity");
                a.add("{{player}} got killed by gravity");
                a.add("{{player}} lost their wings");
                a.add("{{player}} didn't do their physics homework");
                a.add("{{player}} left their parachute at home");
                this.customMessages.set("fell from a high place", a);
                
                a = this.customMessages.getStringList("was killed trying to hurt");
                a.add("{{player}} was killed trying to hurt {{killer}}");
                a.add("{{player}} tried hurting {{killer}} and it backfired");
                this.customMessages.set("was killed trying to hurt", a);
                
                a = this.customMessages.getStringList("was hit the ground too hard");
                a.add("{{player}} hit the ground too hard");
                a.add("{{player}} tripped on a lego and died");
                a.add("{{player}} didn't do their physics homework");
                a.add("{{player}} got killed by gravity");
                a.add("{{player}} lost their wings");
                a.add("{{player}} believed they could fly... They couldn't...");
                this.customMessages.set("hit the ground too hard", a);
                
                a = this.customMessages.getStringList("went up in flames");
                a.add("{{player}} went up in flames");
                a.add("{{player}} is well-done and ready to be eaten");
                a.add("{{player}} got really hot");
                this.customMessages.set("went up in flames", a);
                
                a = this.customMessages.getStringList("burned to death");
                a.add("{{player}} burned to death");
                a.add("{{player}} got roasted");
                a.add("{{player}} was playing with fire");
                this.customMessages.set("burned to death", a);
                
                
                try {
                    this.customMessages.save(file);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (IOException e) {
                System.out.println("[TallcraftDeathMessages] Could not write to messages.yml config file!");
            }
        } else {
            this.customMessages = YamlConfiguration.loadConfiguration((File)file);
        }
    }

    public YamlConfiguration getMessages() {
        return this.customMessages;
    }
}