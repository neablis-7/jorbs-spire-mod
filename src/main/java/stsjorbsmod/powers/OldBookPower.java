package stsjorbsmod.powers;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import static stsjorbsmod.patches.EnumsPatch.SPECIAL;

public class OldBookPower extends CustomJorbsModPower {
    public static final StaticPowerInfo STATIC = StaticPowerInfo.Load(OldBookPower.class);
    public static final String POWER_ID = STATIC.ID;

    private AbstractCard card;

    public OldBookPower(final AbstractCreature owner, AbstractCard card, int amount) {
        super(STATIC);

        this.isTurnBased = false;
        this.card = card;
        this.owner = owner;
        this.amount = amount;
        this.type = SPECIAL;

        updateDescription();
    }

    public AbstractCard getCard() {
        return card;
    }

    @Override
    public void updateDescription() {
        if (card.upgraded)
            description = String.format(DESCRIPTIONS[1], card.magicNumber);
        else
            description = DESCRIPTIONS[0];
    }

    @Override
    public AbstractPower makeCopy() {
        return new OldBookPower(owner, card, amount);
    }
}
