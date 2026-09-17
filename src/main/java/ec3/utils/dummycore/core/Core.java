package ec3.utils.dummycore.core;

public class Core {

    // private static void registerConfigurationFileForMod(Class<?> c, String path)
    // {
    // try
    // {
    // if(!isModRegistered(c))
    // {
    // LoadingUtils.makeACrash("[DummyCore]Catched an attempt to register configuration file for not registered mod,
    // this should not be possible and many things will go wrong as a result!", new IllegalStateException(c+" Is not a
    // valid DCMod!"), false);
    // }else
    // {
    // DCMod mod = getModFromClass(c);
    // File file = new File(path,mod.ufName+".cfg");
    // if(file.isDirectory())
    // file.delete();
    //
    // if(!file.exists())
    // file.createNewFile();
    //
    // Configuration cfg = new Configuration(file);
    // cfg.save();
    // mod.injectFMLConfig(cfg);
    // Notifier.notifySimple("Configuration File for mod "+mod+" was successfully created with path
    // "+path+mod.ufName+".cfg");
    // }
    // }
    // catch(IOException e)
    // {
    // DCMod mod = getModFromClass(c);
    // LoadingUtils.makeACrash("[DummyCore]Could not create a config file for mod "+mod+" - check your file system!", e,
    // true);
    // }
    // }

}
