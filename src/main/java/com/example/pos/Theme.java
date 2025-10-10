package com.example.pos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Theme {
    @JsonProperty("primary")
    private String primary;
    @JsonProperty("secondary")
    private String secondary;
    @JsonProperty("background")
    private String background;
    @JsonProperty("text")
    private String text;

    public String getPrimary() { return primary; }
    public String getSecondary() { return secondary; }
    public String getBackground() { return background; }
    public String getText() { return text; }
}
