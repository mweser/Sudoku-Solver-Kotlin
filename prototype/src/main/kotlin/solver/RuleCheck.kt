package solver

import components.Table

abstract class RuleCheck {
    abstract fun check(table: Table): Int
}