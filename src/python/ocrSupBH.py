import cv2
import pytesseract
import poppler
from pdf2image import convert_from_path
images = convert_from_path('folheto.pdf',500,poppler_path = r"C:\Users\Allan\Downloads\Release-23.01.0-0\poppler-23.01.0\Library\bin")
for i in range(len(images)):
    images[i].save('page'+ str(i) +'.jpg', 'JPEG')
pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract.exe'
texto=""
img=cv2.imread("page0.jpg")
texto+=pytesseract.image_to_string(img)
img=cv2.imread("page1.jpg")
texto+=pytesseract.image_to_string(img)
texto2=texto.strip('\n')
with open("ocrSupermercadoBH.txt","w",encoding="utf-8") as f:
    f.write(texto2)

print("desta vez eu não esqueci de abrir o arquivo")