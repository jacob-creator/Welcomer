package com.jacobcreator.Welcomer;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;

import java.io.IOException;
import java.nio.file.Paths;

public class Config {
    private ConfigurationLoader<CommentedConfigurationNode> loader;
    private CommentedConfigurationNode config;

    public Config() {
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() throws IOException {
        loader = HoconConfigurationLoader.builder().setPath(Paths.get("config/welcomer/config.conf")).build();
        config = loader.load();
    }

    public void save() throws IOException {
        loader.save(config);
    }

    public CommentedConfigurationNode getConfig() {
        return config;
    }
}
