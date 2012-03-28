//
// (c) 2006 DS Data Systems UK Ltd, All rights reserved.
//
// DS Data Systems and KonaKart and their respective logos, are
// trademarks of DS Data Systems UK Ltd. All rights reserved.
//
// The information in this document is free software;you can redistribute
// it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This software is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//

package com.konakart.client.app;

import com.google.gwt.user.client.rpc.IsSerializable;
/** */
public class GWT_PdfResult implements IsSerializable
{
/** */
public String fileName;

/** */
public byte[] pdfBytes;

/** */
public int resultCode;

/** */
public String fileNameAfterBase;

/** @return fileName */
public String getFileName()
{
   return fileName;
}

/** @param fileName */
public void setFileName(String fileName)
{
   this.fileName = fileName;
}

/** @return pdfBytes */
public byte[] getPdfBytes()
{
   return pdfBytes;
}

/** @param pdfBytes */
public void setPdfBytes(byte[] pdfBytes)
{
   this.pdfBytes = pdfBytes;
}

/** @return resultCode */
public int getResultCode()
{
   return resultCode;
}

/** @param resultCode */
public void setResultCode(int resultCode)
{
   this.resultCode = resultCode;
}

/** @return fileNameAfterBase */
public String getFileNameAfterBase()
{
   return fileNameAfterBase;
}

/** @param fileNameAfterBase */
public void setFileNameAfterBase(String fileNameAfterBase)
{
   this.fileNameAfterBase = fileNameAfterBase;
}

}
