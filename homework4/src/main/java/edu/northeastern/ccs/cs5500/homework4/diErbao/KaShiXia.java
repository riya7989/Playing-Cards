/**
 * 
 */
package edu.northeastern.ccs.cs5500.homework4.diErbao;

import java.util.Objects;

/**
 * The card implementation.
 * @author yì xiē rén
 *
 */
public class KaShiXia implements Ka {

	/** Card rank. */
	private final int kaHao; // card number
	
	/** Card suit. */
	private final int suit;
	
	/**
	 * Instantiates a new ka shi xia.
	 *
	 * @param kaHao the ka hao
	 * @param suit the suit
	 */
	public KaShiXia(int kaHao, int suit) {

		validateSuit(suit);

		if ((kaHao < 0) || (kaHao > 12)) {
			throw new IllegalArgumentException("ill-formed card");
		}

		this.kaHao = kaHao;

		this.suit = suit;
	}
	
	/**
	 * Instantiates a new ka shi xia.
	 *
	 * @param kaHao the ka hao
	 * @param suit the suit
	 */
	public KaShiXia(KaDengJiEnum kaHao, int suit) {

		if (kaHao == null) {
			throw new IllegalArgumentException("ill-formed ka");
		}

		validateSuit(suit);

		this.kaHao = kaHao.value;

		this.suit = suit;
	}

	/**
	 * private method to determine if a suit is within range.
	 * 
	 * @param suit	the suit to check for
	 * @author Riya Nadkarni   (fixed the if condition to accommodate 4 values of suit)
	 */
	private void validateSuit(int suit) {
		if ((suit < 0) || (suit >= 4)) {
			throw new IllegalArgumentException("ill-formed ka");
		}
	}

	/* 
	 * @see diErBao.Ka#getRank()
	 */
	@Override
	public int getRank() {

		return kaHao;
	}

	/* 
	 * @see diErBao.Ka#getSuit()
	 */
	@Override
	public int getSuit() {

		return suit;
	}

	@Override
	public String toString() {
		return kaHao + " of " + KaPianTaoZhuangEnum.getKaPianTaoZhuang(getSuit());
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Ka) {

			KaShiXia ka = (KaShiXia) object;
			return (ka.kaHao == this.kaHao && ka.suit == this.suit);
		} else {
			return super.equals(object);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(kaHao, suit);
	}

	/**
	 * Enum of card suits. 
	 */
	public enum KaPianTaoZhuangEnum {
		
		/** The suits. */
		xin, tieQiao, zuanShi, juLeBu; // hearts, spades, diamonds, clubs

		/** List of all suits. */
		private static KaPianTaoZhuangEnum[] list = KaPianTaoZhuangEnum.values();

		/** 
		 * Retrieves an enum from the list.
		 * @param i	the index of the desired enum
		 * @return	the enum at index i
		 */
		public static KaPianTaoZhuangEnum getKaPianTaoZhuang(int i) {
			return list[i];
		}

	}

	/**
	 * Enum of card ranks.
	 */
	public enum KaDengJiEnum {
		
		/** The ranks. */
		TWO(0b0101), THREE(0b1001), FOUR(0b1101), FIVE(0b0100), SIX(0b1000), SEVEN(0b1100), EIGHT(0b0011), NINE(0b0111),
		/** The ranks continued. */
		TEN(0b1011), JACK(0b0010), QUEEN(0b0110), KING(0b1010), ACE(0b0001);

		/** Value of the rank. */
		private int value;

		/**
		 * Constructor for the rank.
		 * @param value	value of the rank.
		 */
		private KaDengJiEnum(int value) {
			this.value = value;
		}

		/**
		 * Converts the given integer to a corresponding rank enum.
		 * @param correspondingValue	value of the rank
		 * @return	the rank of the card
		 */
		public static KaDengJiEnum lookupEnumName(int correspondingValue) {

			KaDengJiEnum result = null;
			
			for (KaDengJiEnum kaRank : KaDengJiEnum.values()) {

				if (correspondingValue == kaRank.value) {
					result = kaRank;
				}
			}
			return result;
		}
	}


}
