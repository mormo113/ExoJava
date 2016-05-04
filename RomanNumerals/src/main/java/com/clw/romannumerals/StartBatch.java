package com.clw.romannumerals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartBatch {

	private static final String PAR_D = ")";
	private static final String PAR_G = "(";
	private static final String VIRGULE = ", ";
	private static final String INPUT_FILE = "input.txt";
	private static final String UTF_8 = "UTF-8";
	private static final String OUTPUT_FILE = "output.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		log("Lancement du traitement...");

		try {
			// Lecture et du fichier en entree et conversion
			readFileAndProcess(INPUT_FILE);

			log("Fin du traitement");

		} catch (IOException e) {
			log("Erreur technique lors du traitement.");
			e.printStackTrace();
		} catch (URISyntaxException e) {
			log("Erreur technique lors du traitement.");
			e.printStackTrace();
		} 

	}


	/**
	 * 
	 * @param aFileName
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	static void readFileAndProcess(String aFileName)
			throws IOException, URISyntaxException {
		
		log("Chargement du fichier [" + aFileName + "]");
		
		Path path = Paths.get(aFileName);
		List<String> lines = new ArrayList<String>();
		RomanNumerals romanNumerals = new RomanNumerals();

		if(!Files.exists(path)){
			log("Le fichier " + aFileName + "est introuvable!");
			return;
		}
		try (BufferedReader reader = Files.newBufferedReader(path,
				Charset.forName(UTF_8))) {
			String line = null;
			
			log("Traitement encours ...");
			
			while ((line = reader.readLine()) != null) {
				if(!isValidLine(line)){
					log("ERROR : L'entree doit etre un nombre positif superieur a 0. [" + line + "]");
					continue;
				}
				lines.add((PAR_G + line + VIRGULE
						+ romanNumerals.fromArabicToRoman(Integer.valueOf(line)) + PAR_D));

				if (isCommitIntervalRiched(lines.size())) {
					writeFile(OUTPUT_FILE, lines);
					lines.clear();
				}
			}
			
			if (lines.size() > 0) {
				writeFile(OUTPUT_FILE, lines);
				lines.clear();
			}
		}
	}

	private static boolean isValidLine(String line) {
		Pattern pattern = Pattern.compile("^[1-9][0-9]*$");
        Matcher matcher = pattern.matcher(line);
        boolean matches = matcher.matches();
        
		return matches;
	}


	/**
	 * 
	 * @param aFileName
	 * @param aLines
	 * @throws IOException
	 */
	static void writeFile(String aFileName, List<String> aLines)
			throws IOException {
		Path path = Paths.get(aFileName);
		if(!Files.exists(path)){
			Files.createFile(path);
		}
		try (BufferedWriter writer = Files.newBufferedWriter(path,
				Charset.forName(UTF_8), StandardOpenOption.APPEND)) {
			for (String line : aLines) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	private static boolean isCommitIntervalRiched(int i) {

		if (i >= 4) {
			return true;
		}

		return false;
	}
	
	private static void log(Object aMsg){
	    System.out.println(String.valueOf(aMsg));
	 }

}
