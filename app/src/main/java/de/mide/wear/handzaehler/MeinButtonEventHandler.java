package de.mide.wear.handzaehler;

import android.view.View;


public class MeinButtonEventHandler implements View.OnClickListener {

    protected MainActivity _mainActivity = null;


    /** Konstruktor */
    public MeinButtonEventHandler(MainActivity mainActivity) {

        _mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {

        if (v == _mainActivity.getPlusButton() ) {

            _mainActivity.erhoeheZaehlerUmEins();

        } else if (v == _mainActivity.getMinusButton() ) {

            _mainActivity.vermindereZaehlerUmEins();
        }

        _mainActivity.aktualisiereZaehlerAnzeige();
    }

}
