import os

import PIL.Image as Image
import zsil.cool_stuff as cool_stuff

originaldir = "originals"
fixeddir = r"..\..\app\src\main\res\drawable-v24"
bonussize = 0.05
for originalfilename in os.listdir(originaldir):
    if originalfilename.endswith("ora"):
        continue
    img = Image.open(os.path.join(originaldir, originalfilename)).convert("RGBA")
    img = cool_stuff.crop_to_content(img)

    extrawidth = round(img.width * bonussize)
    extraheight = round(img.height * bonussize)
    img = img.crop((-extrawidth, -extraheight, img.width+extrawidth, img.height+extraheight))

    img.save(os.path.join(fixeddir, "card_"+originalfilename
                          .replace("-", "minus")
                          .replace("+", "plus")
                          ))