package com.example.fooddelivery.presentation.main

interface Destination {
    var route: String
}


object Start: Destination {
    override var route: String
        get() = "start"
        set(value) {}

}

object Login : Destination {
    override var route: String
        get() = "login"
        set(value) {}

}

object Register : Destination {
    override var route: String
        get() = "register"
        set(value) {}

}

object Bio : Destination {
    override var route: String
        get() = "bio"
        set(value) {}

}

object Payment : Destination {
    override var route: String
        get() = "payment"
        set(value) {}

}

object CreditCart : Destination {
    override var route: String
        get() = "credit-cart"
        set(value) {}

}

object ForgotPassword : Destination {
    override var route: String
        get() = "forgot-password"
        set(value) {}

}

object ChangePassword : Destination {
    override var route: String
        get() = "reset-password"
        set(value) {}

}


object CongratsChangePassword : Destination {
    override var route: String
        get() = "congrats-password"
        set(value) {}

}

object Home : Destination {
    override var route: String
        get() = "home"
        set(value) {}

}

object NotificationsDestination : Destination {
    override var route: String
        get() = "notifications"
        set(value) {}

}

object RestaurantPage : Destination {
    override var route: String
        get() = "restaurant-details"
        set(value) {}
}

object Favorites : Destination {
    override var route: String
        get() = "all-favourites"
        set(value) {}
}


object Testimonials : Destination {
    override var route: String
        get() = "testimonials"
        set(value) {}
}


object PopularMenu : Destination {
    override var route: String
        get() = "popular-menu"
        set(value) {}
}



object OrderDetails : Destination {
    override var route: String
        get() = "order-details"
        set(value) {}
}





