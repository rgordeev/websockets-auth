package ru.rgordeev

import ru.rgordeev.launcher.Launcher
import spock.lang.Specification

/**
 * Created by rgordeev on 14.07.16.
 */
class LauncherSpec extends Specification {

    def "exists applications enter point"() {
        expect: "main method exists"
            Launcher.metaClass.respondsTo(Launcher, "main")
    }

}
