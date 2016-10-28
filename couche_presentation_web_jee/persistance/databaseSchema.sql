--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.4.5
-- Started on 2016-09-14 03:07:00 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 178 (class 3079 OID 11903)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2075 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 16768)
-- Name: don; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE don (
    id integer NOT NULL,
    projet_id integer,
    personne_id integer,
    valeur integer
);


--
-- TOC entry 173 (class 1259 OID 16771)
-- Name: don_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE don_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2076 (class 0 OID 0)
-- Dependencies: 173
-- Name: don_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE don_id_seq OWNED BY don.id;


--
-- TOC entry 174 (class 1259 OID 16773)
-- Name: personne; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE personne (
    id integer NOT NULL,
    nom character varying(500),
    prenom character varying(500),
    datenaiss date,
    login character varying(100),
    mdp character varying(100)
);


--
-- TOC entry 175 (class 1259 OID 16779)
-- Name: personne_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE personne_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2077 (class 0 OID 0)
-- Dependencies: 175
-- Name: personne_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE personne_id_seq OWNED BY personne.id;


--
-- TOC entry 176 (class 1259 OID 16781)
-- Name: projet; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE projet (
    id integer NOT NULL,
    nom character varying(100),
    objectif integer,
    description character varying(2000)
);


--
-- TOC entry 177 (class 1259 OID 16784)
-- Name: projet_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE projet_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2078 (class 0 OID 0)
-- Dependencies: 177
-- Name: projet_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE projet_id_seq OWNED BY projet.id;


--
-- TOC entry 1941 (class 2604 OID 16786)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY don ALTER COLUMN id SET DEFAULT nextval('don_id_seq'::regclass);


--
-- TOC entry 1942 (class 2604 OID 16787)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY personne ALTER COLUMN id SET DEFAULT nextval('personne_id_seq'::regclass);


--
-- TOC entry 1943 (class 2604 OID 16788)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY projet ALTER COLUMN id SET DEFAULT nextval('projet_id_seq'::regclass);


--
-- TOC entry 2063 (class 0 OID 16768)
-- Dependencies: 172
-- Data for Name: don; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO don (id, projet_id, personne_id, valeur) VALUES (1, 1, 1, 300);
INSERT INTO don (id, projet_id, personne_id, valeur) VALUES (6, 2, 1, 33);


--
-- TOC entry 2079 (class 0 OID 0)
-- Dependencies: 173
-- Name: don_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('don_id_seq', 6, true);


--
-- TOC entry 2065 (class 0 OID 16773)
-- Dependencies: 174
-- Data for Name: personne; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO personne (id, nom, prenom, datenaiss, login, mdp) VALUES (1, NULL, NULL, NULL, 'admin', 'admin');


--
-- TOC entry 2080 (class 0 OID 0)
-- Dependencies: 175
-- Name: personne_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('personne_id_seq', 1, true);


--
-- TOC entry 2067 (class 0 OID 16781)
-- Dependencies: 176
-- Data for Name: projet; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO projet (id, nom, objectif, description) VALUES (1, 'projet 1', 1000, 'le plus beau projet du monde');
INSERT INTO projet (id, nom, objectif, description) VALUES (2, 'projet 2', 500, 'non, c''est le mien');


--
-- TOC entry 2081 (class 0 OID 0)
-- Dependencies: 177
-- Name: projet_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('projet_id_seq', 2, true);


--
-- TOC entry 1945 (class 2606 OID 16790)
-- Name: don_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY don
    ADD CONSTRAINT don_pkey PRIMARY KEY (id);


--
-- TOC entry 1949 (class 2606 OID 16792)
-- Name: personne_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (id);


--
-- TOC entry 1951 (class 2606 OID 16794)
-- Name: projet_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY projet
    ADD CONSTRAINT projet_pkey PRIMARY KEY (id);


--
-- TOC entry 1946 (class 1259 OID 16816)
-- Name: fki_dn_personne_id_fkey; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_dn_personne_id_fkey ON don USING btree (personne_id);


--
-- TOC entry 1947 (class 1259 OID 16810)
-- Name: fki_don_projet_id_fkey; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_don_projet_id_fkey ON don USING btree (projet_id);


--
-- TOC entry 1953 (class 2606 OID 16811)
-- Name: dn_personne_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY don
    ADD CONSTRAINT dn_personne_id_fkey FOREIGN KEY (personne_id) REFERENCES personne(id);


--
-- TOC entry 1952 (class 2606 OID 16805)
-- Name: don_projet_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY don
    ADD CONSTRAINT don_projet_id_fkey FOREIGN KEY (projet_id) REFERENCES projet(id);


-- Completed on 2016-09-14 03:07:01 CEST

--
-- PostgreSQL database dump complete
--

