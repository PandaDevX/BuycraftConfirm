package net.splodgebox.buycraftconfirm.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.splodgebox.buycraftconfirm.BuycraftConfirm;
import net.splodgebox.buycraftconfirm.utils.Chat;
import net.splodgebox.buycraftconfirm.utils.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Package {

    private final String name;
    private final Material material;
    private final String display;
    private final List<String> commands;
    private final List<String> message;

    public ItemStack create() {
        return new ItemStackBuilder(getMaterial())
                .setName(getDisplay())
                .setLore(Chat.replacePlaceholders(BuycraftConfirm.getInstance().getConfig().getStringList("Settings.lore"),
                        "{NAME}", getName()))
                .build();
    }
}