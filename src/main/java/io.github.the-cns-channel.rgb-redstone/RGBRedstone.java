package (io.github.the-cns-channel.rgb-redstone);

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("removal")
@Mod(RGBRedstone.MOD_ID)
public class RGBRedstone {

  public static String MOD_ID = "rgbredstone";
  public static Logger logger = LoggerFactory.getLogger(RGBRedstone.class);

  public RGBRedstone(IEventBus bus) {

    FMLJavaModLoadingContext.get().getModEventBus().addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
      fmlCientSetupEvent.enqueueWork(() -> {
        ModList.get(getModContainerById(MOD_ID).ifPresent(modContainer -> {
          logger.info("Loaded {}, using version {}", modContainer.getModInfo().getDisplayName(), modContainer.getModInfo().getVersion());
        });
      });
    }));
  }
}
