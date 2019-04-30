package org.ringingmaster.ui.common;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.ringingmaster.engine.parser.assignparsetype.ParseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * TODO comments???
 * User: Stephen
 */
public class CompositionStyle {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public enum CompositionStyleColor {
        CALLING_POSITION,
        CALL,
        SPLICE,
        BLOCK,
        VARIANCE,
        GROUP,
        DEFINITION,
        PLAIN_LEAD,
        NOTES,
        TITLE,
        AUTHOR,
        UNCHANGED_LH,
        CHANGED_LH,

        GRID,

        FALLBACK,
    }

    public enum CompositionStyleFont {
        TITLE,
        AUTHOR,
        MAIN,
        DEFINITION,
        NOTES
    }

    private final Color[] colors = new Color[CompositionStyleColor.values().length];
    private final Font[] fonts = new Font[CompositionStyleFont.values().length];

    public CompositionStyle() {
        setColor(CompositionStyleColor.CALLING_POSITION, Color.rgb(0, 160, 0));
        setColor(CompositionStyleColor.CALL, Color.rgb(0, 0, 255));
        setColor(CompositionStyleColor.SPLICE, Color.rgb(255, 128, 0));
        setColor(CompositionStyleColor.BLOCK, Color.rgb(140, 140, 140));
        setColor(CompositionStyleColor.VARIANCE, Color.rgb(108, 0, 108));
        setColor(CompositionStyleColor.GROUP, Color.rgb(0, 128, 128));
        setColor(CompositionStyleColor.DEFINITION, Color.rgb(140, 140, 140));
        setColor(CompositionStyleColor.PLAIN_LEAD, Color.rgb(141, 183, 91));
        setColor(CompositionStyleColor.NOTES, Color.rgb(0, 0, 0));
        setColor(CompositionStyleColor.TITLE, Color.rgb(0, 0, 0));
        setColor(CompositionStyleColor.AUTHOR, Color.rgb(0, 0, 129));
        setColor(CompositionStyleColor.UNCHANGED_LH, Color.rgb(170, 170, 170));
        setColor(CompositionStyleColor.CHANGED_LH, Color.rgb(100, 0, 0));
        setColor(CompositionStyleColor.GRID, Color.GREY);

        setColor(CompositionStyleColor.FALLBACK, Color.RED);

        setFont(CompositionStyleFont.TITLE, new Font("Arial", 24));
        setFont(CompositionStyleFont.AUTHOR, new Font("Arial", 27));
        setFont(CompositionStyleFont.MAIN, new Font("Arial", 40));
        setFont(CompositionStyleFont.DEFINITION, new Font("Arial", 30));
        setFont(CompositionStyleFont.NOTES, new Font("Arial", 10));
    }

    public void setColor(CompositionStyleColor type, Color color) {
        colors[type.ordinal()] = color;
    }

    public Color getColour(CompositionStyleColor compositionStyleColor) {
        return colors[compositionStyleColor.ordinal()];
    }

    public Color getColourFromParseType(ParseType parseType) {

        switch (parseType) {
            case CALLING_POSITION:
                return getColour(CompositionStyleColor.CALLING_POSITION);
            case CALL:
            case CALL_MULTIPLIER:
            case DEFAULT_CALL_MULTIPLIER:
                return getColour(CompositionStyleColor.CALL);
            case SPLICE:
            case SPLICE_MULTIPLIER:
                return getColour(CompositionStyleColor.SPLICE);
            case PLAIN_LEAD:
            case PLAIN_LEAD_MULTIPLIER:
                return getColour(CompositionStyleColor.PLAIN_LEAD);
            case DEFINITION:
            case DEFINITION_MULTIPLIER:
                return getColour(CompositionStyleColor.DEFINITION);
            case VARIANCE_OPEN:
            case VARIANCE_DETAIL:
            case VARIANCE_CLOSE:
                return getColour(CompositionStyleColor.VARIANCE);
            case MULTIPLIER_GROUP_OPEN:
            case MULTIPLIER_GROUP_OPEN_MULTIPLIER:
            case MULTIPLIER_GROUP_CLOSE:
                return getColour(CompositionStyleColor.GROUP);
//TODO 			case BLOCK_DEFINITION:
//			case BLOCK_DEFINITION_MULTIPLIER:
//				return getColour(CompositionStyleColor.BLOCK);

            default:
                log.warn("Getting fallback colour for [{}]", parseType);
                return getColour(CompositionStyleColor.FALLBACK);
        }
    }

    public void setFont(CompositionStyleFont type, Font font) {
        fonts[type.ordinal()] = font;
    }

    public Font getFont(CompositionStyleFont compositionStyleFont) {
        return fonts[compositionStyleFont.ordinal()];
    }

}
