package com.jacobcreator.Welcomer;


import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.game.state.GamePostInitializationEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;

import org.spongepowered.api.text.serializer.TextSerializers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Plugin(id = "welcomer",name = "DaBabyWelcomer", description = "DABABY!", version = "1.0.2")
public class Main {

    Config config = new Config();

    @Listener
    public void onPlayerConnection(ClientConnectionEvent.Join event, @Root Player player){
        //player.sendMessage(Text.of("DABABY"));
        //player.sendMessage(TextSerializers.FORMATTING_CODE.deserialize("&b&lDABABY!"));
        Task.builder().execute(()->{
            player.sendMessage(textObject(config.getConfig().getNode("WelcomerMessage").getString("&bDefault Message")));
        }).delay(2, TimeUnit.SECONDS).submit(this);
    }

    public static Text textObject(String message){
       return TextSerializers.FORMATTING_CODE.deserialize(message);
    }
    @Listener
    public void onGameReload(GameReloadEvent event) throws IOException {
        config.load();
    }
}
