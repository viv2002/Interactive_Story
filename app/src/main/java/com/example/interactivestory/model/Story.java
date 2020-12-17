package com.example.interactivestory.model;

import com.example.interactivestory.R;

public class Story {
    private page[] pages;
    public Story(){
        pages = new page[7];

        pages[0] = new page(R.drawable.ic_launcher_background,R.string.page0,
                new choice(R.string.page0choice_1,1),
                new choice(R.string.page0choice_2,2));

        pages[1] = new page(R.drawable.ic_launcher_background,R.string.page1,
                new choice(R.string.page1choice_1,3),
                new choice(R.string.page1choice_2,4));

        pages[2] = new page(R.drawable.ic_launcher_background,R.string.page2,
                new choice(R.string.page2choice_1,4),
                new choice(R.string.page2choice_2,6));

        pages[3] = new page(R.drawable.ic_launcher_background,R.string.page3,
                new choice(R.string.page3choice_1,5),
                new choice(R.string.page3choice_2,4));

        pages[4] = new page(R.drawable.ic_launcher_background,R.string.page4,
                new choice(R.string.page4choice_1,5),
                new choice(R.string.page4choice_2,6));

        pages[5] = new page(R.drawable.ic_launcher_foreground,R.string.page5);

        pages[6] = new page(R.drawable.ic_launcher_foreground,R.string.page6);
    }
}
