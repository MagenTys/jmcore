package io.magentys.cinnamon.webdriver.remote

import com.typesafe.config.Config
import org.openqa.selenium.remote.DesiredCapabilities

class Perfecto extends CinnamonRemote {

  override val name: String = "perfecto"

  override def matchesHubUrl(url: String): Boolean = url.endsWith("perfectomobile/wd/hub")

  override def capabilities(browserProfile: String, config: Config): DesiredCapabilities = {
    val mainRemoteCaps: DesiredCapabilities = super.capabilities(browserProfile,config)

    //TODO Here we can add names, build numbers etc - Dependency on the "handlers"
    val additionalRemoteCaps = new DesiredCapabilities
    //    additionalRemoteCaps.setCapability("name", "someName")
    //    additionalRemoteCaps.setCapability("build", "someBuild")

    mainRemoteCaps.merge(additionalRemoteCaps)
  }
}