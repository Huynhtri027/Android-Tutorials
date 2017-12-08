allprojects {
    repositories {
        jcenter()
        maven{
            url 'https://dl.bintray.com/fynd/maven/'
        }
    }
}



----------------------------------------------------------
dependencies{
......
compile 'co.gofynd.library:gravity-view:1.0'
}