
DROP TABLE IF EXISTS Devise;


######################## CREATE  TABLE ########################################

CREATE TABLE Devise(
	codeDevise VARCHAR(8),
	monnaie VARCHAR(64),
	dChange double,
	
	PRIMARY KEY(codeDevise));	

#########################  INSERT INTO   #####################################

INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('E',1.2,'euro');
INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('Y',0.2,'yen');
INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('D',1.0,'dollar');
INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('L',1.1,'livre');