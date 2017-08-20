package org.ringingmaster.ui.common;

import org.ringingmaster.engine.touch.parser.ParseType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO comments???
 * User: Stephen
 */
public class TouchStyle {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public enum TouchStyleColor {
		CALLING_POSITION,
		CALL,
		SPLICE,
		BLOCK,
		VARIANCE,
		GROUP,
		DEFINITON,
		PLAIN_LEAD,
		NOTES,
		TITLE,
		AUTHOR,
		UNCHANGED_LH,
		CHANGED_LH,

		GRID,

		FALLBACK,
	}

	public enum TouchStyleFont {
		TITLE,
		AUTHOR,
		MAIN,
		DEFINITION,
		NOTES
	}

	private final Color[] colors = new Color[TouchStyleColor.values().length];
	private final Font[] fonts = new Font[TouchStyleFont.values().length];

	public TouchStyle() {
		setColor(TouchStyleColor.CALLING_POSITION,Color.rgb(0,  160,0  ));
		setColor(TouchStyleColor.CALL,            Color.rgb(0,  0,  255));
		setColor(TouchStyleColor.SPLICE,          Color.rgb(255,128,0  ));
		setColor(TouchStyleColor.BLOCK,           Color.rgb(140,140,140));
		setColor(TouchStyleColor.VARIANCE,        Color.rgb(108,0,  108));
		setColor(TouchStyleColor.GROUP,           Color.rgb(0,  128,128));
		setColor(TouchStyleColor.DEFINITON,       Color.rgb(140,140,140));
		setColor(TouchStyleColor.PLAIN_LEAD,      Color.rgb(141,183,91 ));
		setColor(TouchStyleColor.NOTES,           Color.rgb(0,  0,  0  ));
		setColor(TouchStyleColor.TITLE,           Color.rgb(0,  0,  0  ));
		setColor(TouchStyleColor.AUTHOR,          Color.rgb(0,  0,  129));
		setColor(TouchStyleColor.UNCHANGED_LH,    Color.rgb(170,170,170));
		setColor(TouchStyleColor.CHANGED_LH,      Color.rgb(100,0,  0  ));
		setColor(TouchStyleColor.GRID,            Color.GREY);

		setColor(TouchStyleColor.FALLBACK,        Color.BLACK);

		setFont(TouchStyleFont.TITLE,       new Font ("Arial", 24));
		setFont(TouchStyleFont.AUTHOR,      new Font ("Arial", 27));
		setFont(TouchStyleFont.MAIN,        new Font ("Arial", 40));
		setFont(TouchStyleFont.DEFINITION,  new Font ("Arial", 30));
		setFont(TouchStyleFont.NOTES,       new Font ("Arial", 10));
	}

	public void setColor(TouchStyleColor type, Color color) {
		colors[type.ordinal()] = color;
	}

	public Color getColour(TouchStyleColor touchStyleColor) {
		return colors[touchStyleColor.ordinal()];
	}

	public Color getColourFromParseType(ParseType parseType) {

		switch (parseType) {
			case CALLING_POSITION:
				return getColour(TouchStyleColor.CALLING_POSITION);
			case CALL:
			case CALL_MULTIPLIER:
			case DEFAULT_CALL_MULTIPLIER:
				return getColour(TouchStyleColor.CALL);
			case SPLICE:
			case SPLICE_MULTIPLIER:
				return getColour(TouchStyleColor.SPLICE);
			case PLAIN_LEAD:
			case PLAIN_LEAD_MULTIPLIER:
				return getColour(TouchStyleColor.PLAIN_LEAD);
			case DEFINITION:
			case DEFINITION_MULTIPLIER:
				return getColour(TouchStyleColor.DEFINITON);
			case VARIANCE_OPEN:
			case VARIANCE_CLOSE:
				return getColour(TouchStyleColor.VARIANCE);
			case GROUP_OPEN:
			case GROUP_OPEN_MULTIPLIER:
			case GROUP_CLOSE:
				return getColour(TouchStyleColor.GROUP);
//TODO 			case BLOCK_DEFINITION:
//			case BLOCK_DEFINITION_MULTIPLIER:
//				return getColour(TouchStyleColor.BLOCK);

			case UNPARSED:
			case WHITESPACE:
				return getColour(TouchStyleColor.FALLBACK);
			default:
				log.warn("Getting fallback colour for [{}]", parseType);
				return getColour(TouchStyleColor.FALLBACK);
		}
	}

	public void setFont(TouchStyleFont type, Font font) {
		fonts[type.ordinal()] = font;
	}

	public Font getFont(TouchStyleFont touchStyleFont) {
		return fonts[touchStyleFont.ordinal()];
	}

}
