/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Button;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {
        /** Default translation for the word */
        private String mDefaultTranslation;
        /** Miwok translation for the word */
        private String mMiwokTranslation;

        /** Audio resource ID for the word */
        private int mAudioResourceId;

        //* declares a list icon for a new word */
        private int mListIcon = NO_IMAGE_PROVIDED;
        //* Private variable, used only within the Word class, random number, so it will
       // not coincide with any possible image resource name*/

        private static final int NO_IMAGE_PROVIDED = -1;

     /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
      *
      *@param audioResourceId is the resource ID for the audio file associated with this word
     */

        public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
            mDefaultTranslation = defaultTranslation;
            mMiwokTranslation = miwokTranslation;
            mAudioResourceId = audioResourceId;
        }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     * @param listIcon is a drawable resource ID for the image associated with the word
     *
     *@param audioResourceId is the resource ID for the audio file associated with this word
     */


        public Word(String defaultTranslation, String miwokTranslation, int listIcon, int audioResourceId) {
            mDefaultTranslation = defaultTranslation;
            mMiwokTranslation = miwokTranslation;
            mListIcon=listIcon;
            mAudioResourceId = audioResourceId;

        }
        /**
         * Get the default translation of the word.
         */
        public String getDefaultTranslation() {
            return mDefaultTranslation;
        }
        /**
         * Get the Miwok translation of the word.
         */
        public String getMiwokTranslation() {
            return mMiwokTranslation;
        }

        /* Get drawable resource ID for the image associated with the word
         */
        public int getListIcon () {
            return mListIcon;

        }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mAudioResourceId=" + mAudioResourceId +
                ", mListIcon=" + mListIcon +
                '}';
    }

    /** returns whether there is image or not for this word
         * @return
         */
         public boolean hasImage(){
        return mListIcon != NO_IMAGE_PROVIDED; /** != means NOT equal to */
        }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}