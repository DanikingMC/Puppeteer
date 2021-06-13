package puppeteer.common.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import puppeteer.common.Puppeteer;
import puppeteer.common.item.wand.PuppeteerWandItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModObjects {
        //I usually make a LinkedHashMap here for both items a blocks
        //I like LinkedHashMap because it stores the order that you put the objects here
        //So the same way you put your objects here it's showed in creative tab
    //--------------MAP FOR ITEMS-------------------//

    public static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    public static final Item NPC_WAND = createItem("puppeteer_wand", new PuppeteerWandItem(setGroup()));
//    public static final Item NPC_EGG = createItem("npc_egg", new SpawnEggItem(ModEntityTypes.NPC,0x7f3f00,0xc0c0c0, setGroup()));

    private static Item.Settings setGroup(){
        return new Item.Settings().group(ItemGroup.MISC).maxCount(1);
    }

    private static <T extends Item> T createItem(String name, T item) {
        ITEMS.put(item, new Identifier(Puppeteer.MODID, name));
        return item;
    }

    public static void init () {
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));

    }
}
