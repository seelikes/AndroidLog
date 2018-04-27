# AndroidLog
print log unit
## dependency
* add repository

        maven {
            url "http://112.74.29.196:34272/repository/maven-public/"
        }
* add it to your dependencies

        implementation "com.github.seelikes.android:log:1.0.1"
* initialize it in your Application
this is not necessary when you do not care about whether log should be print

        SaLogConstants.setLevel(BuildConfig.DEBUG ? SaLogConstants.VERBOSE : SaLogConstants.ERROR);

* concept

    when we analysis our application's logs, it is very important that we tell:

    * where the log comes from.

    we use class and method to locate this where problem.

    * what the log say

    we use msg to show the log message.

    **thus all our log method accept 3 parameters, the class, the method locate the log print point, the msg processes the log itself.**

## sample

        SaLog.i(MainActivity.class, "onCreate", "enter");
