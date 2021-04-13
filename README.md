# Frostbar
Want an even more realistic Minecraft server? Why not make players feel cold when walking on a cold block? Here is the just plugin!

## What is that?
This is a Minecraft plugin that adds you the possibility to fell cold when you step near a cold block such like snow and ice. And, if you want to warm up, 
place a torch near you!

## The config
This plugin has got some options that you can edit such like the freezing message or the bar title. Here is the config file:
```yml
# The settings.
# Colors char: '&'
Settings:

  # The title of the boss_bar
  # Value: String with colors
  BossbarTitle: "&bFreezing State"

  # The player regenerate by this value every 2 ticks when he isn't near a freezing source.
  # Value: Decimal number
  NormalRegen: 0.05

  # The area where the plugin searches any freezing or heat source. If it finds something in this region, it provides
  # to increase or decrease the "FreezingState".
  # Values: Numbers (Decimal or not)
  FreezeArea:

    # The range of the area
    AreaRange: 1

  # The values to increase every 2 tick when the player is near a freezing material such like ice or snow
  # Values: Numbers (Decimal or not)
  FreezingState:

    # When the player is near the snow, his freezing state increase by this value
    SnowFreeze: 0.00005

    # Else, when the player is near an ice block, his freezing state increase by this value
    IceFreeze: 0.0005

    # The regen of a torch when it's in the player-freeze area.
    TorchRegeneration: 0.015

  # If the player has got the value of the FreezeBar to 1, the plugin starts doing that you see below.
  FrozenState:

    # The ticks before do damage to the player
    # Value: Integer number
    DamageTicks: 40

    # The damage that the player get every "DamageTicks"
    # Value: Integer number
    FreezeDamage: 2

    # The message that will be send to the player when his bar reach the 1 value
    # Value: "String" with colors
    FrozenMessage: "&bYou're Freezing! Place a torch or get out the snow/ice!"
```

## What types of blocks does the plugin use as heaters or ice chillers?
Here is a table that can help you:
Block|Function|Default Value
-|-|-
Ice Block|Freeze|0.0005
Snow / Snow Block|Freeze|0.00005
Torch|Heat|0.015

## License
Remember to read the license before use the code. But also remember that this plugin is open source! Enjoy!
