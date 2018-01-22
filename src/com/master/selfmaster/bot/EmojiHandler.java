package com.master.selfmaster.bot;


import java.util.HashMap;

public class EmojiHandler
{
    public HashMap<String,String> emojis;

    public EmojiHandler(){
        this.emojis = new HashMap<>();
        this.emojis.put("<3",":black_heart:");
        this.emojis.put("<<3", ":black_heart:");
        this.emojis.put(":heart:", ":black_heart:");
        this.emojis.put("</3", ":broken_heart:");
        this.emojis.put("<fzeroq>", "¯\\_(ツ)_/¯");
        this.emojis.put("<malicia>", "( ͡° ͜ʖ ͡°)");
        this.emojis.put("<moon>", "( ͡° ͜ʖ ͡°)");
        this.emojis.put("<flip>", "(ノಠ益ಠ)ノ彡┻━┻");
        this.emojis.put("<rly>" , "(◔_◔)");
        this.emojis.put("<why>", "ლ(ಠ_ಠლ)");
        this.emojis.put("<god>", "(シ_ _)シ");
        this.emojis.put("<rip>", "⎧ᴿᴵᴾ⎫");
        this.emojis.put("<tocae>", "(ノﾟДﾟ)八(ﾟДﾟ )ノ");
    }

    public HashMap<String, String> getEmojis() {
        return emojis;
    }
}
