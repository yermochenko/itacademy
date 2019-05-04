import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
	public static List<Enemy> readEnemies(String fileName) throws IOException {
		Reader a = new FileReader(fileName);
		BufferedReader b = new BufferedReader(a);
		String x;
		List<Enemy> enemies = new ArrayList<>();
		while((x = b.readLine()) != null) {
			String s[] = x.split(" ");
			Enemy e = new Enemy(
				new Color(
					Integer.parseInt(s[3]),
					Integer.parseInt(s[4]),
					Integer.parseInt(s[5])
				),
				Integer.parseInt(s[1]),
				Integer.parseInt(s[2]),
				Integer.parseInt(s[0])
			);
			enemies.add(e);
		}
		b.close();
		return enemies;
	}
}
