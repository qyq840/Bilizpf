package com.zhaopengfei.myapplication.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by admin on 2017/3/25.
 */

public class HisPlayBean {

    /**
     * code : 0
     * data : [{"title":"【1月】小林家的龙女仆 11【独家正版】","cover":"http://i1.hdslb.com/bfs/archive/a1080d35c404c099ee066646113fca17a5f131e5.jpg_320x200.jpg","uri":"bilibili://video/9326290","param":"9326290","goto":"av","name":"哔哩哔哩番剧","play":1299115,"danmaku":32165,"reply":23,"favourite":577,"pts":1299115},{"title":"【1月/完结】火影忍者 疾风传 720","cover":"http://i1.hdslb.com/bfs/archive/2deda6733b8266ec67ae536aee93aa068ecdc5d7.jpg_320x200.jpg","uri":"bilibili://video/9341465","param":"9341465","goto":"av","name":"TV-TOKYO","play":756442,"danmaku":62549,"reply":21,"favourite":3463,"pts":756442},{"title":"【1月】人渣的本愿 11【幻樱】","cover":"http://i0.hdslb.com/bfs/archive/1e2ce0f65ab7d6be7464cb64dcf71158117d7a8a.jpg_320x200.jpg","uri":"bilibili://video/9352370","param":"9352370","goto":"av","name":"真鱼","play":507584,"danmaku":20922,"reply":25,"favourite":1388,"pts":507584},{"title":"【4月】双星之阴阳师 49","cover":"http://i1.hdslb.com/bfs/archive/4a69258c93dba82814810066f57b0f981a3d3ac5.jpg_320x200.jpg","uri":"bilibili://video/9323043","param":"9323043","goto":"av","name":"TV-TOKYO","play":373201,"danmaku":12809,"reply":8,"favourite":149,"pts":373201},{"title":"【1月/完结】SEIREN 清恋 12","cover":"http://i0.hdslb.com/bfs/archive/92992943edf75317a8f61bb9dae8f1a8f8d06e17.jpg_320x200.jpg","uri":"bilibili://video/9354347","param":"9354347","goto":"av","name":"哔哩哔哩番剧","play":179813,"danmaku":11141,"favourite":119,"pts":179813},{"title":"【1月/完结】URARA迷路帖 12【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/c07088fed4a6314824b6dc1af72cb120e8acef1c.jpg_320x200.jpg","uri":"bilibili://video/9354354","param":"9354354","goto":"av","name":"哔哩哔哩番剧","play":156441,"danmaku":13709,"reply":5,"favourite":177,"pts":156441},{"title":"【1月/完结】风夏 12","cover":"http://i2.hdslb.com/bfs/archive/35568a527a83e51b8dfa391d9aa946e15a19c4cc.jpg_320x200.jpg","uri":"bilibili://video/9361867","param":"9361867","goto":"av","name":"哔哩哔哩番剧","play":136970,"danmaku":9738,"reply":7,"favourite":92,"pts":136970},{"title":"【1月】One Room 11【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/f1658f3ead2dccd45186cfb9efcc34608ed26f11.jpg_320x200.jpg","uri":"bilibili://video/9324701","param":"9324701","goto":"av","name":"哔哩哔哩番剧","play":124149,"danmaku":1295,"reply":2,"favourite":91,"pts":124149},{"title":"【1月】秋叶原之旅 12【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/2251ac1a81b23075d089ee75827c53d203b8b6dc.jpg_320x200.jpg","uri":"bilibili://video/9325758","param":"9325758","goto":"av","name":"哔哩哔哩番剧","play":96700,"danmaku":3900,"reply":2,"favourite":79,"pts":96700},{"title":"【OVA】机动战士敢达 雷霆宙域战线 05【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/4782a41b9bafd53aba9373126d572624792d851c.jpg_320x200.jpg","uri":"bilibili://video/9343907","param":"9343907","goto":"av","name":"哔哩哔哩番剧","play":82494,"danmaku":2308,"reply":2,"favourite":196,"pts":82494},{"title":"【1月】CHAOS;CHILD 11【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/2ceed9bbd3d7fc38a4f46b01b44a52c282312c68.jpg_320x200.jpg","uri":"bilibili://video/9331337","param":"9331337","goto":"av","name":"哔哩哔哩番剧","play":64778,"danmaku":1627,"reply":4,"favourite":66,"pts":64778},{"title":"【长篇】精灵宝可梦 日月 19【枫叶】","cover":"http://i2.hdslb.com/bfs/archive/caa710a762235b3db127f7347e85d48cefbf2e8e.jpg_320x200.jpg","uri":"bilibili://video/9361648","param":"9361648","goto":"av","name":"真鱼","play":50884,"danmaku":2343,"reply":2,"favourite":157,"pts":50884},{"title":"【OVA】珈百璃的堕落OVA 01【F宅】","cover":"http://i2.hdslb.com/bfs/archive/86a4796e21333822b85c370ceb04df8e9d35a93f.jpg_320x200.jpg","uri":"bilibili://video/9343225","param":"9343225","goto":"av","name":"空灵雨迹","play":48844,"danmaku":2024,"reply":10,"favourite":1500,"pts":48844},{"title":"【OVA】机动战士敢达 雷霆宙域战线 01【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/c4833f76b82d30803ac1eddc67a2a06aea787782.jpg_320x200.jpg","uri":"bilibili://video/9343934","param":"9343934","goto":"av","name":"哔哩哔哩番剧","play":46279,"danmaku":733,"reply":2,"favourite":162,"pts":46279},{"title":"【8月/韩漫】心灵的声音 61-62","cover":"http://i0.hdslb.com/bfs/archive/5630d3d798d4f5267002b1869e86d9ac872cf61b.jpg_320x200.jpg","uri":"bilibili://video/9322133","param":"9322133","goto":"av","name":"番剧烤肉","play":36115,"danmaku":584,"favourite":29,"pts":36115},{"title":"【短篇动画】梦王国与沉睡的100王子 01【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/c5d807a4e1935db40872c585f014f633fec3d67b.jpg_320x200.jpg","uri":"bilibili://video/9359669","param":"9359669","goto":"av","name":"哔哩哔哩番剧","play":26715,"danmaku":1265,"reply":1,"favourite":106,"pts":26715},{"title":"【720P/DVDRip】拳皇 极限冲击 续章 异日之战【内嵌字幕】","cover":"http://i0.hdslb.com/bfs/archive/99bb7b616908f91e67d21e0480bef72952f4c681.jpg_320x200.jpg","uri":"bilibili://video/9341423","param":"9341423","goto":"av","name":"堕落吧樱花残雪","play":13393,"danmaku":49,"favourite":175,"pts":13393},{"title":"【生肉/OVA】珈百璃的堕落OVA 01","cover":"http://i1.hdslb.com/bfs/archive/c9b16655283713c7817df82abe1ee88f514cb375.jpg_320x200.jpg","uri":"bilibili://video/9336950","param":"9336950","goto":"av","name":"F宅总动员","play":13038,"danmaku":454,"reply":4,"favourite":221,"pts":13038},{"title":"【1月】人渣的本愿 11【生肉】","cover":"http://i0.hdslb.com/bfs/archive/af4d35c8d1febda33642828ef60de4c0e2625497.jpg_320x200.jpg","uri":"bilibili://video/9350865","param":"9350865","goto":"av","name":"八云境界","play":8245,"danmaku":302,"reply":1,"favourite":67,"pts":8245},{"title":"【4月】sin七大罪 PV2","cover":"http://i1.hdslb.com/bfs/archive/932b791d34ef520f16030750100bc448529118bf.jpg_320x200.jpg","uri":"bilibili://video/9341048","param":"9341048","goto":"av","name":"ACG速报","play":7942,"danmaku":32,"reply":5,"favourite":192,"pts":7942}]
     * message :
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 【1月】小林家的龙女仆 11【独家正版】
         * cover : http://i1.hdslb.com/bfs/archive/a1080d35c404c099ee066646113fca17a5f131e5.jpg_320x200.jpg
         * uri : bilibili://video/9326290
         * param : 9326290
         * goto : av
         * name : 哔哩哔哩番剧
         * play : 1299115
         * danmaku : 32165
         * reply : 23
         * favourite : 577
         * pts : 1299115
         */

        private String title;
        private String cover;
        private String uri;
        private String param;
        @JSONField(name = "goto")
        private String gotoX;
        private String name;
        private int play;
        private int danmaku;
        private int reply;
        private int favourite;
        private int pts;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }

        public int getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(int danmaku) {
            this.danmaku = danmaku;
        }

        public int getReply() {
            return reply;
        }

        public void setReply(int reply) {
            this.reply = reply;
        }

        public int getFavourite() {
            return favourite;
        }

        public void setFavourite(int favourite) {
            this.favourite = favourite;
        }

        public int getPts() {
            return pts;
        }

        public void setPts(int pts) {
            this.pts = pts;
        }
    }
}
