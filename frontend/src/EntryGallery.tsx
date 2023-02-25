import {GuestbookEntry} from "./GuestbookEntry";
import EntryCard from "./EntryCard";
import AddEntry from "./AddEntry";

type EntryGalleryProps = {
    entries: GuestbookEntry[],
}

export default function EntryGallery(props: EntryGalleryProps){
    const entryCard = props.entries.map((entry) => {
        return(
            <EntryCard entry={entry} key={entry.id} />
        );
    }).reverse();

    return(
        <div>
            <AddEntry />
            {entryCard}
        </div>
    );
}
