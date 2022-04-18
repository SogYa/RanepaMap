package com.sogya.projects.instruments

import com.sogya.projects.R

enum class BuildingsEnum(val imageResource: Int) {
    FIRST(R.drawable.building1) {
        override fun getFirstFloor(): Int {
            return R.drawable.building1
        }

        override fun getSecondFloor(): Int {
            return R.drawable.building1
        }
    },
    SECOND(R.drawable.korpus2) {
        override fun getFirstFloor(): Int {
            return R.drawable.korpus2
        }

        override fun getSecondFloor(): Int {
            return R.drawable.korpus2
        }

        fun getThirdFloor(): Int {
            return R.drawable.korpus2
        }
    },
    THIRD(R.drawable.korpus3) {
        override fun getFirstFloor(): Int {
            return R.drawable.korpus3
        }

        override fun getSecondFloor(): Int {
            return R.drawable.korpus3
        }
    },
    FIVE(R.drawable.korpus5) {
        override fun getFirstFloor(): Int {
            return R.drawable.korpus5
        }

        override fun getSecondFloor(): Int {
            return R.drawable.korpus5
        }
    },
    SIX(R.drawable.korpus6) {
        override fun getFirstFloor(): Int {
            return R.drawable.korpus6
        }

        override fun getSecondFloor(): Int {
            return R.drawable.korpus6
        }
    };

    abstract fun getFirstFloor(): Int
    abstract fun getSecondFloor(): Int
}