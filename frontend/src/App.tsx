import React, {useEffect, useState} from 'react';
import './App.css';
import {Route, Routes} from "react-router-dom";
import EntryGallery from "./EntryGallery";
import axios from "axios";
import {GuestbookEntry} from "./GuestbookEntry";

function App() {

    const [entries, setEntries] = useState<GuestbookEntry[]>([])

    useEffect(() => {
        axios.get("/api/guestbook-entries")
            .then((response) => {
                setEntries(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);

    return (
        <div className="App">
            <Routes>
                <Route path={"/"} element={<EntryGallery entries={entries}/>}/>
            </Routes>
        </div>
    );
}

export default App;
